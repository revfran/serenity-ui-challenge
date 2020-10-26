# serenity-ui-challenge
A simple challenge to run tests against an ecom website

# Requisites
- Maven with Java 8
- Tested with chromedriver (86) against Chrome v86 on Windows. Due to technical issues I couldn't advance to make Firefox work on Windows.
- Tested with chromedriver (86) against Chrome v86 on Mac.
- Tested with geckodriver (0.27) against Firefox v82 on Mac. 


# Adding support for other webdriver/os/browser
- Add the driver to [drivers](src/test/resources/drivers), add the path in [serenity.conf](src/test/resources/serenity.conf)
- To execute with this driver, change [serenity.conf](src/test/resources/serenity.conf) or set -Dwebdriver.driver property when launching the tests

# How to execute

This command will execute tests and create serenity reports

With Firefox
```
$ mvn test -Dwebdriver.driver=firefox serenity:aggregate
```

With Firefox
```
$ mvn test -Dwebdriver.driver=chrome serenity:aggregate
```

Reports are be available after execution in [./target/site/serenity/index.html]

Sample reports are available at 
- Firefox execution [index.html](./executions/firefox/serenity/index.html)
- Chrome execution [index.html](./executions/chrome/serenity/index.html)

# Description of the building process
- Start from [serenity-rest-challenge](https://github.com/revfran/serenity-rest-challenge)
- Adapt dependencies
- Create skeleton with PageObject model following ideas from Serenity cucumber starter project
- Run simplest scenario (access URL) with different browsers
- Split logic using [a proper architecture](https://github.com/serenity-bdd/screenplay-pattern-todomvc)

# Testing ideas
- To come up with a realistic approach to automate some of the paths with 3-5 tests is completely unfeasible.
- When logging in two prompts appear that are a bit annoying for just browsing. One to set a delivery location (why is that needed if I just want to check items? I don't remember something similar when visiting other ecom websites), and another one regarding the cookie tracking.
- Checking more info about how adidas cookie tracking works I end up in a URL that it's not in english https://www.adidas.fi/help-topics-privacy_policy.html with no option to switch to English.
- Going to any page after the first one triggers a prompt to sign up to get a 20% discount... that does not help a lot to engage a new user, from my point of view.
- What would be a blocker? Not being able to search for a popular term and check out the product
- What is a popular term? there are suggestions in the page so I will use them
    - Ultraboost
    - Sst tracksuit
    - Ozweego
    - Gazelle
    - Predator
- Default sorting of items after going to the popular terms is not clear for the user. In fact checking any of the default filters (Price,Newest,Top Sellers) does not end in the sorting that is shown by default (checked with [ultraboost](https://www.adidas.fi/ultraboost)).   
- Not being logged can provide a different user experience, but testing the sign in and being logged in would require test data management, so I set them out of scope.
- Being able to pay and have sent the item no matter where the user is also a key feature, but also requires test data management.
- Highlights of current campaigns to be shown also seem a key feature, as we would expect different experiences over time. Also customization of page depending of logged in profile could be interesting.
- Being able to browse through categories also seems key, as not a lot of users may directly enter a term in the search bar. I will explore one category for the three highlighted ones:
    - Men
    - Women
    - Kids
- Funnily enough, when going to Reebok main page, "Women" and "Men" categories are switched when compared to adidas.   
- I wonder if "Men" being before "Women" in categories is due to sales ranks, or if there would be a more appropriate way to show categories without any kind of controversy. In that regard the video in the main page shows "Ivy Park", which seems to target Women users, so sorting does not seem consistent.
- There's a suggestion for "BLACK FRIDAY: EARLY ACCESS", but there's no clear explanation of what that early access means, even after clicking "Sign up". Why a user would bother to "Sign up" then?
- Summarising, a lot of deep testing following different heuristics would be the best approach for this task, as providing a test plan with 3-5 UI automated checks wouldn't be helping a lot any stakeholder. For the sake of the challenge I provide them, of course.

# Problems found
- Some issues were found when exploring, with and without automation. Those are available in [issues](./defects)
- Having to run the tests locally is a very complex requirement, that makes configuration more difficult, harder to maintain as browsers/webdrivers change versions, and less portable. I like projects like [zalenium](https://github.com/zalando/zalenium for this
- Headless chrome browser couldn't be used, as it ends up in a page with a 403 warning. Switching headless flag in serenity.conf solved the issue. Added proof to [defects folder](./defects/headlessChrome)
- Chromedriver in mac can't be opened because the developer cannot be verified: [solution link](https://stackoverflow.com/questions/60362018/macos-catalinav-10-15-3-error-chromedriver-cannot-be-opened-because-the-de)
- Firefox in Windows wouldn't load pages. Versions were compatible. I think it was due to headless configuration in serenity.conf, as I had no problem with Firefox on Mac.
- Modal windows (delivery popup/accept tracking) are not easy to identify via a unique id or css class, so tests associated with them may be a bit flaky.
- Overlay category suggestions that appears when typing in search bar don't contain a class to easily locate the elements
- Store URL for an article is not only related to the article, however I realised, for testability, that going to https://www.adidas.fi/{articleNumber}.html redirects correctly, at least for EH2861 and a couple of other articles I tried.

# References
- [Serenity cucumber starter project](https://github.com/serenity-bdd/serenity-cucumber-starter) 
package com.vlad.project.stepdefs

import com.vlad.project.pages.GebishOrgHomePage
import com.vlad.project.pages.TheBookOfGebPage


import static cucumber.api.groovy.EN.*

Given(~/^I'm at the GebishOrgHomePage$/) { ->
    browser.drive() {
        to GebishOrgHomePage
    }
}
When(~/^I click$/) { ->
    browser.drive(){
        at GebishOrgHomePage
        manualsMenu.open()
//    manualsMenu.links[0].text().startsWith("current")
        manualsMenu.links[0].click()
    }
}
Then(~/^I see the manual page$/) { ->
    browser.drive() {
        at TheBookOfGebPage
    }
}

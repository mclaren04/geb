package com.vlad.project.stepdefs

import com.vlad.project.TestWorld
import cucumber.api.groovy.Hooks
import cucumber.api.groovy.EN
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import geb.Browser
import geb.binding.BindingUpdater

import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

World {
    new TestWorld()
}

Before() {
//    bindingUpdater = new BindingUpdater(binding, new Browser())
//    bindingUpdater.initialize()
    initializeBrowser()
}

//After() {
//    bindingUpdater.remove()
//}
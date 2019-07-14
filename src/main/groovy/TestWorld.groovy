package com.vlad.project

import geb.Browser

import java.util.concurrent.BrokenBarrierException

class TestWorld {
    static Browser browser

    static void initializeBrowser() {
        browser = new Browser()
    }

    @SuppressWarnings('GrMethodMayBeStatic')
    Browser drive(String user = 'default', Closure c) {
        browser.drive(c)
    }

    @SuppressWarnings(['GroovyUnusedDeclaration', 'GrMethodMayBeStatic'])
    Browser driveAt(Class klass, String user = 'default', Closure c) {
        browser.drive(c)
    }
}

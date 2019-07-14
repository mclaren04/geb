package com.vlad.project.pages

import geb.Page
import com.vlad.project.Modules.ManualsMenuModule

class GebishOrgHomePage extends Page {

    static at = { title == "Geb - Very Groovy Browser Automation" }

    static content = {
        manualsMenu { module ManualsMenuModule }
    }
}
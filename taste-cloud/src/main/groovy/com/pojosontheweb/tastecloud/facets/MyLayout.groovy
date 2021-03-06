package com.pojosontheweb.tastecloud.facets

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.BaseFacet
import woko.facets.builtin.Layout
import woko.facets.builtin.WokoFacets
import woko.facets.builtin.all.LayoutAll

import woko.facets.builtin.bootstrap3.all.LayoutBootstrap3

@FacetKey(name= WokoFacets.layout, profileId="all")
class MyLayout extends LayoutBootstrap3 {

    // return the title for your app, used in page titles, main navbar etc.
    @Override
    String getAppTitle() {
        return "taste-cloud"
    }

    @Override
    String getLayoutPath() {
        '/WEB-INF/jsp/layout.jsp'
    }

    @Override
    List<String> getCssIncludes() {
        def all = new ArrayList(super.getCssIncludes())
        all << '/css/taste.css'
        all << '/image-picker/image-picker.css'
        all << '/orion/built-editor.css'
        return all
    }

    @Override
    List<String> getJsIncludes() {
        def all = new ArrayList(super.getJsIncludes())
        all << '/image-picker/image-picker.min.js'
        all << '/orion/built-editor.min.js'
        return all
    }

}

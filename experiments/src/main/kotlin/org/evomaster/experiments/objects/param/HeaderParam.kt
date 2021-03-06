package org.evomaster.experiments.objects.param

import org.evomaster.core.search.gene.Gene


class HeaderParam(name: String, gene: Gene) : Param(name, gene){

    override fun copy(): Param {
        return HeaderParam(name, gene.copy())
    }
}
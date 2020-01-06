package org.evomaster.resource.rest.generator.model

/**
 * created by manzh on 2019-08-15
 */
enum class RestMethod {
    POST,
    POST_VALUE,
    PUT,
    //PUT_VALUE,
    GET_ID,
    GET_ALL,
    GET_ALL_CON, // get all resoruces with constraints on its owners by their ids
    //PATCH,
    PATCH_VALUE,
    DELETE,
    DELETE_CON
}
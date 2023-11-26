package gti.g55.eventichs_organisation.Domaine.Interacteurs

open class OrganisationException: Throwable{
    constructor(e: Exception?): super(e) {}
    constructor(msg: String?): super(msg) {}
}
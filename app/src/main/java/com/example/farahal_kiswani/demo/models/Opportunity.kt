package com.example.farahal_kiswani.demo.models

data class Opportunity(
    val id: Int,
    val name: String,
    val desc: String,
    val full_desc: String,
    val organization: Organization,
    val specialities: List<Speciality>,
    val interests: List<Interest>,
    val opportunity_targets: List<OpportunityTarget>,
    val required_documents: List<RequiredDocument>,
    val education_levels: List<EducationLevel>,
    val funding: Funding,
    val funding_coverage: List<FundingCoverage>,
    val type: Type,
    val nationalities: List<Nationality>,
    val place_of_residence: List<PlaceOfResidence>,
    val languages: List<Language>,
    val gender: String,
    val min_age: Int,
    val max_age: Int,
    val closing_date: Int,
    val deadline: String,
    val closing_date_text: String,
    val is_ad: Int,
    val how_to_apply: String,
    val contact_details: String,
    val benefits: String,
    val other_info: Any,
    val pic: String,
    val image: Image,
    val created_date: Int,
    val lang: String,
    val opportunity_place: String,
    val pins_count: Int,
    val applies_count: Int,
    val views_count: Int,
    val comments_count: Int,
    val is_owner: Boolean,
    val url: String,
    val slug_en: String,
    val slug: String,
    val full_url: String,
    val cat_img: String,
    val featured: Int,
    val tags: String,
    val translations: Translations,
    val isPinned: Int,
    val isApplied: Int,
    val can_delete: Int
)
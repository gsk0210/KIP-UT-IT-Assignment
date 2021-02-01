package com.knoldus.db

import org.scalatest.flatspec.AsyncFlatSpec


class CompanyReadDtoTest extends AsyncFlatSpec {

  val companyReadDto=new CompanyReadDto

  "Company Knoldus" should "be present in database" in{
    val companyDetails=companyReadDto.getCompanyByName("Knoldus")
    assert(companyDetails.nonEmpty)
  }

  "Company Philips" should "be present in database" in{
    val companyDetails=companyReadDto.getCompanyByName("Philips")
    assert(companyDetails.nonEmpty)
  }

  "Company Microsoft" should "not be present in database" in{
    val companyDetails=companyReadDto.getCompanyByName("Microsoft")
    assert(companyDetails.isEmpty)
  }

}

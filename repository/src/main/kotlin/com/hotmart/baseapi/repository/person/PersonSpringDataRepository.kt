package com.hotmart.baseapi.repository.person

import com.hotmart.baseapi.data.PersonDataMapper
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PersonSpringDataRepository : CrudRepository<PersonDataMapper, UUID> {}

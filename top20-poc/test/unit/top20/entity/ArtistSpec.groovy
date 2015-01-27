package top20.entity

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Artist)
class ArtistSpec extends Specification {


	def "realName constraints"() {
		setup:
		mockForConstraintsTests(Artist)

		when:
		def artist = new Artist(realName: realName, stageName:"Queen")
		artist.validate()

		then:
		artist.hasErrors() == !valid

		where:
		realName | valid
		"" | false
		"Real name" | true
	}

	def "stageName constraints"() {
		setup:
		mockForConstraintsTests(Artist)

		when:
		def artist = new Artist(realName: "Freddie Mercury", stageName: stageName)
		artist.validate()

		then:
		artist.hasErrors() == !valid

		where:
		stageName | valid
		"" | false
		"Stage name" | true
	}
}

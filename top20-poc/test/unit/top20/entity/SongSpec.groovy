package top20.entity

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Song)
class SongSpec extends Specification {


	def "name not blank"() {
		setup:
		mockForConstraintsTests(Song)
		mockDomain(Artist)

		when:
		def song = new Song(name: name, artist: new Artist(realName:"Freddie Mercury",stageName:"Queen").save())
		song.validate()

		then:
		song.errors.hasFieldErrors("name")

		where:
		name = "";

	}
	
	
	def "artist not blank"() {
		setup:
		mockForConstraintsTests(Song)
		mockDomain(Artist)

		when:
		def song = new Song(name: "All I want", artist: null)
		song.validate()

		then:
		song.errors.hasFieldErrors("artist")
 }

	
}

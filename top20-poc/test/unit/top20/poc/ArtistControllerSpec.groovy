

package top20.poc

import grails.test.mixin.TestFor
import spock.lang.Specification
import top20.entity.Artist
import top20.service.ArtistService

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ArtistController)
@Mock(Artist)
class ArtistControllerSpec extends Specification {

	def mockService;

	def setup() {
		mockService = 	mockFor(ArtistService)
		controller.artistService = mockService.createMock();
	}

	def cleanup() {
	}

	void "test createNew"() {
		when:
		controller.createNew();

		then:
		view == '/artist/addArtist'
	}

	void "test list"() {
		given:
		mockService.demand.list() { -> return [new Artist()]}

		when:
		controller.list();

		then:
		model.artistCount == 1;
		model.artistInstanceList != null;
	}

	void "test save"() {
		given:
		Artist art = new Artist([stageName:"test", realName:"test"]);
		mockService.demand.saveArtist(_) { ->}
		
		when:
		controller.saveArtist(art);

		then:
		response.redirectedUrl == "/artist/list";
	}
	
	void "test show"() {
		given:
		Artist art = new Artist()

		when:
		controller.show(art);

		then:
		model.artistInstance == art;
	}
}

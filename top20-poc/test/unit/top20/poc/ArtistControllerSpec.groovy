

package top20.poc

import grails.test.mixin.TestFor
import spock.lang.Specification
import top20.entity.Artist
import top20.service.ArtistService

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ArtistController)
@Mock([Artist])
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
		Artist artist = new Artist();
		mockService.demand.list() { -> return [artist]}

		when:
		controller.list();

		then:
		model.artistCount == 1;
		model.artistInstanceList == [artist];
	}

	void "test save : valid"() {
		given:
		Artist art = new Artist([stageName:"test", realName:"test"]);
		mockService.demand.saveArtist(_) { ->}

		when:
		request.method = 'POST'
		controller.save(art);

		then:
		response.redirectedUrl == "/artist/list";
	}

	void "test save : invalid"() {
		given:
		Artist art = new Artist([stageName:"test", realName:""]);

		when:
		request.method = 'POST'
		controller.save(art);

		then:
		view == '/artist/addArtist'
		model.artist == art
	}

	void "test show"() {
		given:
		Artist art = new Artist()

		when:
		controller.show(art);

		then:
		model.artistInstance == art;
	}
	
	
	void "test update: null"() {

		when:
		request.method = 'PUT'
		controller.update(null);

		then:
		response.redirectedUrl == '/artist/list'
	}
	
	void "test update: invalid"() {
		given:
		Artist art = new Artist([stageName:"test", realName:""]);

		when:
		request.method = 'PUT'
		controller.update(art);

		then:
		view == 'edit'
	}
	
	
	void "test delete: invalid"() {
		
		when:
		request.method = 'DELETE'
		controller.delete(null);

		then:
		response.redirectedUrl == '/artist/list'
	}
	
	void "test delete: valid"() {
		given:
		Artist art = new Artist([stageName:"test", realName:""])
		art.save();
		def calls = 0;
		mockService.demand.delete(1) { artParam -> if(art == artParam) calls ++; }
		
		when:
		request.method = 'DELETE'
		controller.delete(art);

		then:
		response.redirectedUrl == '/artist/list'
		calls == 1
	}
}

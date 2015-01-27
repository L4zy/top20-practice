package top20.poc

import top20.entity.Artist

class ArtistController {

	def scaffold = Artist
	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	static defaultAction = "list"
	def artistService

	def createNew() {
		render view:"/artist/addArtist";
	}

	def list() {
		List<Artist> artists = artistService.list();
		respond artists, model:[artistCount: artists.size()]
	}

	def save(Artist artist) {

		if(artist != null && artist.validate()){
			artistService.saveArtist(artist);
		}else{
			artist.errors.allErrors.each { println it }

			render view:"/artist/addArtist",model:[artist:artist]
			return
		}

		redirect action: 'list'
	}

	def show(Artist artist) {
		respond artist
	}

	def edit(Artist artistInstance) {
		respond artistInstance
	}

	def update(Artist artist) {

		if(artist == null ){
			redirect action: 'list'
			return;
		}

		if ( !artist.validate()) {
			respond artist.errors, view:'edit'
			return
		}

		artistService.update(artist);

		redirect action: 'list'
	}

	def delete(Artist artist) {
		if(artist){
			artistService.delete(artist);
		}

		redirect action: 'list'
	}
}

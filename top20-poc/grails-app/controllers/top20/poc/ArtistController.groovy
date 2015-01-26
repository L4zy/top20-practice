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

	def saveArtist(Artist artist) {

		if(artist != null && artist.validate()){
			artistService.saveArtist(artist);
		}else{
			artist.errors.allErrors.each { println it }

			render view:"/artist/addArtist",model:[artist:artist]
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

		if (artist == null || artist.hasErrors()) {
			respond artist.errors, view:'edit'
			return
		}

		artistService.update(artist);
		
		redirect action: 'list'
	}

	def delete(Artist artist) {
		artistService.delete(artist);
		
		redirect action: 'list'
	}
	
}

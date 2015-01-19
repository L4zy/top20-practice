package top20.poc

import top20.entity.Artist

class ArtistController {
	//	def scaffold = Artist
	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	static defaultAction = "list"
	def artistService

	def createNew() {
		render view:"/artist/addArtist";
	}
	
	def list() {
		respond artistService.list(), model:[artistCount: Artist.count()]
	}
	
	def save(Artist artist) {
		
		if(artist.validate()){
			artistService.saveArtist(artist);
		}else{
			artist.errors.allErrors.each {
				println it
			}
			
			render view:"/artist/addArtist",model:[artist:artist]
		}
		
		redirect action: 'list'
		
	}
	
}

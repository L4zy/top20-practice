package top20.poc

import top20.entity.Artist

class ArtistController {
	
	def scaffold = Artist

	List<Artist> list = new ArrayList<Artist>();
	static scope ="session"
	static defaultAction = "initialize"

	def initialize (){
		render view:"/artist/addArtist";
	}

	def addAgain(){
		render view:"/artist/addArtist";
	}


	def artistService
	def add(Artist artist) {
		
		if(artist.validate()){
			artistService.addArtist(artist);
		}else{
			artist.errors.allErrors.each {
				println it
			}
			
			render view:"/artist/addArtist",model:[artist:artist]
		}
		
		redirect action: 'addAgain'
		
	}
}

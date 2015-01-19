package top20.poc

import top20.entity.Song;
import top20.entity.Vote

class SongController {

	
//	def scaffold = Song
	
    static defaultAction = "list"
	
	def artistService
	def songService
	def createNew(){
		render view:"/song/addSong", model:[artistList:artistService.list()];
	}
	
	def save(Song song){
		if(song.validate()){
			songService.saveSong(song);
		}else{
			song.errors.allErrors.each {
				println it
			}
			
			render view:"/artist/addSong",model:[song:song]
		}
		
		redirect action: 'list'
	}
	
	def list() {
		
		respond Song.list(params), model:[songCount: Song.count(), voted : params.voted]
	}
}

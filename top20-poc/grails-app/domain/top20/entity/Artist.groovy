package top20.entity

class Artist {

	Long id;
	String stageName;
	String realName;
	
	static hasMany = [songs: Song]
	
	static mapping = {
		songs cascade: 'all-delete-orphan'
	}

	
	static constraints = {
		stageName(blank: false)
		realName(blank: false)
	}
	
	public String toString(){
		return stageName;
	}
}

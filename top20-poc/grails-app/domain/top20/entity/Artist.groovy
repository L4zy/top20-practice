package top20.entity

class Artist {

	Long id;
	String stageName;
	String realName;
	
	static hasMany = [songs: Song]

	static mapping = {
		songs column: "ID", joinTable: false
	  }
	
	static constraints = {
		stageName(blank: false)
		realName(blank: false)
	}
}

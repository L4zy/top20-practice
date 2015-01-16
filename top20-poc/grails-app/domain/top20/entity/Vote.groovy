package top20.entity

class Vote {

	Long id;
	Date votDate;
	static belongsTo = [song: Song]
	
	
    static constraints = {
    }
}

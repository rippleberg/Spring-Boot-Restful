package com.rest.tutorial.pojo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TvSeries {
	@Null
	private Integer id;
	@NotNull
	private String name;
	@DecimalMin("1")
	private int seasonCount;
    //如果想用long型的timestamp表示日期，可用： @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    @JsonFormat(timezone="GMT+8", pattern="yyyy-MM-dd")
	@Past		 //@Past表示只接受过去的时间，比当前时间还晚的被认为不合格
	private Date originRelease;
	@Valid
	@NotNull
	@Size(min=2)
	private List<TvCharacter> tvCharacters;
	
	public TvSeries() {}
	
	public TvSeries(int id, String name, int seasonCount, Date originRelease, List<TvCharacter> tvCharacters) {
		super();
		this.id = id;
		this.name = name;
		this.seasonCount = seasonCount;
		this.originRelease = originRelease;
		this.tvCharacters = tvCharacters;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeasonCount() {
		return seasonCount;
	}
	public void setSeasonCount(int seasonCount) {
		this.seasonCount = seasonCount;
	}
	public Date getOriginRelease() {
		return originRelease;
	}
	public void setOriginRelease(Date originRelease) {
		this.originRelease = originRelease;
	}
	public List<TvCharacter> getTvCharacters() {
		return tvCharacters;
	}
	public void setTvCharacters(List<TvCharacter> tvCharacters) {
		this.tvCharacters = tvCharacters;
	}

	@Override
	public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(this.getClass().getName()).append("{id:").append(id);
        buf.append(",name:").append(name).append(",seasonCount:").append(seasonCount);
        buf.append("}");
        return buf.toString();
	}
	
}

package cn.kgc.tangcco.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable{
	private Integer id;
	private String name;
	private Integer parentId;
	private String url;
	private String icon;
	private Integer order;
}

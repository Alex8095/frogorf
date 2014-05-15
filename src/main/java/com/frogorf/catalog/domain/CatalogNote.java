package com.frogorf.catalog.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKey;

import com.frogorf.domain.BaseEntity;
import com.frogorf.domain.BaseLocale;

@Entity
@Table(name = "catalog_note")
public class CatalogNote extends BaseEntity {

	@Column
	private String url;
	@Column
	@NotNull
	private int level;
	@Column(name = "is_show")
	private Boolean isShow;
	@Column(name = "is_show_in_menu")
	private Boolean isShowInMenu;

	@JoinTable(name = "catalog_note_locale")
	@CollectionOfElements(targetElement = BaseLocale.class, fetch = FetchType.EAGER)
	@MapKey(targetElement = String.class, columns = @Column(name = "language_code"))
	private Map<String, BaseLocale> catalogNoteLocale = new HashMap<String, BaseLocale>();

	@ManyToOne
	@JoinTable(name = "catalog_note_parent", joinColumns = @JoinColumn(name = "catalog_note_id"), inverseJoinColumns = @JoinColumn(name = "parent_id"))
	private CatalogNote parentCatalogNote;
	@ManyToMany
	@JoinTable(name = "catalog_note_parent", joinColumns = @JoinColumn(name = "parent_id"), inverseJoinColumns = @JoinColumn(name = "catalog_note_id"))
	private List<CatalogNote> catalogNotes;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	public Boolean getIsShowInMenu() {
		return isShowInMenu;
	}

	public void setIsShowInMenu(Boolean isShowInMenu) {
		this.isShowInMenu = isShowInMenu;
	}

	public Map<String, BaseLocale> getCatalogNoteLocale() {
		return catalogNoteLocale;
	}

	public void setCatalogNoteLocale(Map<String, BaseLocale> catalogNoteLocale) {
		this.catalogNoteLocale = catalogNoteLocale;
	}

	public CatalogNote getParentCatalogNote() {
		return parentCatalogNote;
	}

	public void setParentCatalogNote(CatalogNote parentCatalogNote) {
		this.parentCatalogNote = parentCatalogNote;
	}

	public List<CatalogNote> getCatalogNotes() {
		return catalogNotes;
	}

	public void setCatalogNotes(List<CatalogNote> catalogNotes) {
		this.catalogNotes = catalogNotes;
	}

	public BaseLocale getCurrentCatalogLocale(String localeCode) {
		return getCatalogNoteLocale().get(localeCode);
	}

	public BaseLocale getCurrentCatalogNoteLocale() {
		return getCatalogNoteLocale().get(getLocaleLanguage());
	}

	public CatalogNote() {
	}

	@Override
	public String toString() {
		return "CatalogNote [url=" + url + ", level=" + level + ", isShow=" + isShow + ", isShowInMenu=" + isShowInMenu + ", catalogNoteLocale=" + catalogNoteLocale + "]";
	}

}

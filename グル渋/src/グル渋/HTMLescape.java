package グル渋;

public class HTMLescape {
	public String escapeHTML(String str) {			   
			   return str.replace("&", "&amp;")
				          .replace("<", "&lt;")
				          .replace(">", "&gt;")
				          .replace("\"", "&quot;" )
				          .replace("\'", "&#39;" );
		}
}

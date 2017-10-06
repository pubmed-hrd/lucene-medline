package com.medline;

import com.medline.repository.AbstractRepository;
import com.medline.service.Indexing;

public class App {
	public static void main(String[] args) {
		Integer limit = 0;
		boolean isAppend = false;
		String pwd = null, indexPath = null;

		for (int i = 0; i < args.length; i++) {
			if ("-limit".equals(args[i])) {
				limit = Integer.parseInt(args[i + 1]);
				i++;
			} else if ("-indexPath".equals(args[i])) {
				indexPath = args[i + 1];
				i++;
			} else if ("-isAppend".equals(args[i])) {
				isAppend = true;
				i++;
			} else if ("-pwd".equals(args[i])) {
				pwd = args[i + 1] + "!@";
				i++;
			} 
		}

		System.out.println(String.format("limit:%s, pwd:%s, isAppend:%s, indexPath:%s", limit, pwd, isAppend, indexPath));

		Indexing idx = new Indexing(new AbstractRepository(pwd));
		idx.setLimit(limit);
		idx.createIndex(indexPath, isAppend);
	}
}

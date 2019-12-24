package com.automationpractice.wappi.utils.util;

import cucumber.api.DataTable;

public class TransposeDataTable {

	private TransposeDataTable() {
	}

	public static <T> T transposeDataTable(Class<T> c, DataTable datatable) {
		return datatable.transpose().asList(c).get(0);
	}
}

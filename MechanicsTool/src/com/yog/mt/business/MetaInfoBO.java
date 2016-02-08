package com.yog.mt.business;

public class MetaInfoBO extends AbstractBusinessObject implements IMetaInfoBO {

	private static final long serialVersionUID = 1L;

	@Override
	public void getVersion() {
		getResponse().setVersion("1.0");
	}

}

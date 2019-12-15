package org.sheepy.lily.vulkan.demo.test.composite.grow.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.view.IViewAdapter;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.presentation.GenericView;
import org.sheepy.lily.vulkan.demo.test.composite.grow.MainCompositeBufferTest;
import org.sheepy.lily.vulkan.demo.test.composite.grow.model.GrowEngineFactory;

@Adapter(scope = GenericView.class, name = MainCompositeBufferTest.VIEW_NAME)
public class GrowEngineProvider implements IViewAdapter<GenericView>
{
	@Override
	public IEngine buildEngine(GenericView view)
	{
		return GrowEngineFactory.build();
	}
}

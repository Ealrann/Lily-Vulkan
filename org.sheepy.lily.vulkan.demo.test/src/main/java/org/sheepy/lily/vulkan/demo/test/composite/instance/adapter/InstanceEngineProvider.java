package org.sheepy.lily.vulkan.demo.test.composite.instance.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.view.IViewAdapter;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.presentation.GenericView;
import org.sheepy.lily.vulkan.demo.test.composite.instance.MainCompositeInstanceTest;
import org.sheepy.lily.vulkan.demo.test.composite.instance.model.InstanceEngineFactory;

@Adapter(scope = GenericView.class, name = MainCompositeInstanceTest.VIEW_NAME)
public class InstanceEngineProvider implements IViewAdapter<GenericView>
{
	@Override
	public IEngine buildEngine(GenericView view)
	{
		return InstanceEngineFactory.build();
	}
}

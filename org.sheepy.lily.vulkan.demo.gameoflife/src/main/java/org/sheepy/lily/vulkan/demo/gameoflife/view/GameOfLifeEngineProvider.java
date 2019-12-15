package org.sheepy.lily.vulkan.demo.gameoflife.view;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.api.view.IViewAdapter;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.presentation.GenericView;
import org.sheepy.lily.vulkan.demo.gameoflife.MainGameOfLife;
import org.sheepy.lily.vulkan.demo.gameoflife.model.EngineBuilder;

@Adapter(scope = GenericView.class, name = MainGameOfLife.VIEW_NAME)
public class GameOfLifeEngineProvider implements IViewAdapter<GenericView>
{
	@Override
	public IEngine buildEngine(GenericView view)
	{
		final var application = ModelUtil.getApplication(view);
		final var size = application.getSize();
		final var builder = new EngineBuilder(size);
		return builder.build();
	}
}

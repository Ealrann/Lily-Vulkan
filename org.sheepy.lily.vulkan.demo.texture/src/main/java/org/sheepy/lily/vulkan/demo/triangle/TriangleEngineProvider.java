package org.sheepy.lily.vulkan.demo.triangle;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.api.view.IViewAdapter;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.presentation.GenericView;
import org.sheepy.lily.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.lily.vulkan.demo.mesh.MeshModelFactory;

@Adapter(scope = GenericView.class, name = MainTriangle.NAME)
public class TriangleEngineProvider implements IViewAdapter<GenericView>
{
	public static int FRAME_COUNT = 0;

	@Override
	public IEngine buildEngine(GenericView view)
	{
		final var application = ModelUtil.getApplication(view);
		final var size = application.getSize();
		final var meshBuilder = new TriangleMeshBuilder();
		final var meshConfiguration = new MeshConfiguration(meshBuilder, size);
		meshConfiguration.frameCount = FRAME_COUNT;
		final var factory = new MeshModelFactory(meshConfiguration);

		return factory.build();
	}
}

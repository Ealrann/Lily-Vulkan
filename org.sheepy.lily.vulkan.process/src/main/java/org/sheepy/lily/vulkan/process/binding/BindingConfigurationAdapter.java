package org.sheepy.lily.vulkan.process.binding;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.binding.BindingConfiguration;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

import java.util.ArrayList;
import java.util.List;

@ModelExtender(scope = BindingConfiguration.class)
@Adapter(lazy = false)
public final class BindingConfigurationAdapter extends AbstractContextConfigurationAdapter
{
	private BindingConfigurationAdapter(BindingConfiguration config)
	{
		super(config);
	}

	@Override
	protected BindConfiguration newConfiguration(int instance)
	{
		final var bindConfig = (BindingConfiguration) config;
		final List<DescriptorSet> res = new ArrayList<>();
		final int stride = bindConfig.getDescriptorSetStride();
		final var ds = bindConfig.getDescriptorsSets();
		final int first = stride * instance;
		final int count = stride > 0 ? stride : ds.size();

		for (int i = 0; i < count; i++)
		{
			final int index = i + first;
			if (index < ds.size())
			{
				final var descriptorSet = ds.get(index);
				res.add(descriptorSet);
			}
		}

		return new BindConfiguration(instance, List.copyOf(res));
	}

	@Override
	protected int getStride()
	{
		final var bindConfig = (BindingConfiguration) config;
		return bindConfig.getDescriptorSetStride();
	}

	@Override
	protected int getIndexCount()
	{
		final var bindConfig = (BindingConfiguration) config;
		return bindConfig.getDescriptorsSets().size();
	}
}

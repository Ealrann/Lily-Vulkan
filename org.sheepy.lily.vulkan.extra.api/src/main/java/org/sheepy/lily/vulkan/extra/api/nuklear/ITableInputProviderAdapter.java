package org.sheepy.lily.vulkan.extra.api.nuklear;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.model.variable.IVariableResolver;

public interface ITableInputProviderAdapter extends IAdapter
{
	List<TableElementProvider> buildElementProviders(LilyEObject input);

	static final class TableElementProvider
	{
		public final IVariableResolver resolver;
		public final String name;

		public TableElementProvider(IVariableResolver resolver, String name)
		{
			this.resolver = resolver;
			this.name = name;
		}
	}
}

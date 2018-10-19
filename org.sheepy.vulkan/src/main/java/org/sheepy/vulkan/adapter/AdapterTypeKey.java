package org.sheepy.vulkan.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.ISheepyAdapter;

public class AdapterTypeKey
{
	private EObject target;
	private Class<? extends ISheepyAdapter> type;

	public AdapterTypeKey(EObject target, Class<? extends ISheepyAdapter> type)
	{
		this.target = target;
		this.type = type;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		AdapterTypeKey other = (AdapterTypeKey) obj;
		if (target == null)
		{
			if (other.target != null) return false;
		}
		else if (!target.equals(other.target)) return false;
		if (type == null)
		{
			if (other.type != null) return false;
		}
		else if (!type.equals(other.type)) return false;
		return true;
	}
}
package org.sheepy.vulkan.pipeline;

import java.util.List;

public interface ICompositeProcessUnit extends IProcessUnit
{
	List<IProcessUnit> getExecutables();

	void setEnabled(boolean enable);
	boolean isEnabled();

	boolean isDirty();
	void setDirty(boolean b);
}

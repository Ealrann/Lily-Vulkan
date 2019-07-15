/**
 */
package org.sheepy.lily.vulkan.model.process.compute.provider;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;
import org.sheepy.lily.core.model.types.provider.LilyEditPlugin;
import org.sheepy.lily.vulkan.model.process.provider.ProcessEditPlugin;

import org.sheepy.lily.vulkan.model.provider.VulkanEditPlugin;

import org.sheepy.lily.vulkan.model.resource.provider.ResourceEditPlugin;

/**
 * This is the central singleton for the Compute edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class ComputeEditPlugin extends EMFPlugin
{
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ComputeEditPlugin INSTANCE = new ComputeEditPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeEditPlugin()
	{
		super(new ResourceLocator[] {
				ProcessEditPlugin.INSTANCE,
				LilyEditPlugin.INSTANCE,
				VulkanEditPlugin.INSTANCE,
				ResourceEditPlugin.INSTANCE,
				org.sheepy.vulkan.model.barrier.provider.VulkanEditPlugin.INSTANCE,
		});
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator()
	{
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin()
	{
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin
	{
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation()
		{
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

}

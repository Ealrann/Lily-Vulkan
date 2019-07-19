/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericDataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Data Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class GenericDataProviderImpl<T extends Presentation> extends BufferDataProviderImpl<RenderableDataSource<T>> implements GenericDataProvider<T>
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericDataProviderImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return RenderingPackage.Literals.GENERIC_DATA_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public NotificationChain basicSetDataSource(RenderableDataSource<T> newDataSource, NotificationChain msgs)
	{
		return super.basicSetDataSource(newDataSource, msgs);
	}

} //GenericDataProviderImpl

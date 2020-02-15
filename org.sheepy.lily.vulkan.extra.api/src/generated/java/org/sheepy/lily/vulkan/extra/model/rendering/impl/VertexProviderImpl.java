/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider;
import org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vertex Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class VertexProviderImpl<T extends Structure> extends BufferDataProviderImpl<RenderableDataSource<T>> implements VertexProvider<T>
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VertexProviderImpl()
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
		return RenderingPackage.Literals.VERTEX_PROVIDER;
	}

} //VertexProviderImpl

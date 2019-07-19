/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh.impl;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.lily.vulkan.extra.model.mesh.Mesh;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshRenderer;

import org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Renderer</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MeshRendererImpl extends GenericRendererImpl<Mesh> implements MeshRenderer
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeshRendererImpl()
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
		return MeshPackage.Literals.MESH_RENDERER;
	}

} //MeshRendererImpl

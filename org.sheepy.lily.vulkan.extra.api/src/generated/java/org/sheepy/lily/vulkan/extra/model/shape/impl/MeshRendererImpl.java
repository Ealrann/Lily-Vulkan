/**
 */
package org.sheepy.lily.vulkan.extra.model.shape.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl;

import org.sheepy.lily.vulkan.extra.model.shape.IMeshStructure;
import org.sheepy.lily.vulkan.extra.model.shape.MeshRenderer;
import org.sheepy.lily.vulkan.extra.model.shape.ShapePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mesh Renderer</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MeshRendererImpl extends GenericRendererImpl<IMeshStructure> implements MeshRenderer
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
		return ShapePackage.Literals.MESH_RENDERER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<IMeshStructure> getRenderedStructures()
	{
		if (renderedStructures == null)
		{
			renderedStructures = new EObjectResolvingEList<IMeshStructure>(IMeshStructure.class, this, ShapePackage.MESH_RENDERER__RENDERED_STRUCTURES);
		}
		return renderedStructures;
	}

} //MeshRendererImpl

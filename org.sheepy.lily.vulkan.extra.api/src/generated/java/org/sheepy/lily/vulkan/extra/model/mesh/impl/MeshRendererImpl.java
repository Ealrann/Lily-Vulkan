/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sheepy.lily.vulkan.extra.model.mesh.IMeshStructure;
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
		return MeshPackage.Literals.MESH_RENDERER;
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
		if (renderedStructures == null) {
			renderedStructures = new EObjectResolvingEList<IMeshStructure>(IMeshStructure.class, this, MeshPackage.MESH_RENDERER__RENDERED_STRUCTURES);
		}
		return renderedStructures;
	}

} //MeshRendererImpl

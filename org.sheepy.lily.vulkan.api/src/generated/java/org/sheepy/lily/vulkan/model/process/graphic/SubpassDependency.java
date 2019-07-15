/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subpass Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getSrcSubpass <em>Src Subpass</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getDstSubpass <em>Dst Subpass</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getSrcStageMask <em>Src Stage Mask</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getDstStageMask <em>Dst Stage Mask</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getSrcAccesses <em>Src Accesses</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getDstAccesses <em>Dst Accesses</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency()
 * @model
 * @generated
 */
public interface SubpassDependency extends EObject
{
	/**
	 * Returns the value of the '<em><b>Src Subpass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Subpass</em>' reference.
	 * @see #setSrcSubpass(Subpass)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency_SrcSubpass()
	 * @model
	 * @generated
	 */
	Subpass getSrcSubpass();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getSrcSubpass <em>Src Subpass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Subpass</em>' reference.
	 * @see #getSrcSubpass()
	 * @generated
	 */
	void setSrcSubpass(Subpass value);

	/**
	 * Returns the value of the '<em><b>Dst Subpass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Subpass</em>' reference.
	 * @see #setDstSubpass(Subpass)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency_DstSubpass()
	 * @model
	 * @generated
	 */
	Subpass getDstSubpass();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getDstSubpass <em>Dst Subpass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Subpass</em>' reference.
	 * @see #getDstSubpass()
	 * @generated
	 */
	void setDstSubpass(Subpass value);

	/**
	 * Returns the value of the '<em><b>Src Stage Mask</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Stage Mask</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency_SrcStageMask()
	 * @model
	 * @generated
	 */
	EList<EPipelineStage> getSrcStageMask();

	/**
	 * Returns the value of the '<em><b>Dst Stage Mask</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Stage Mask</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency_DstStageMask()
	 * @model
	 * @generated
	 */
	EList<EPipelineStage> getDstStageMask();

	/**
	 * Returns the value of the '<em><b>Src Accesses</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Accesses</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency_SrcAccesses()
	 * @model
	 * @generated
	 */
	EList<EAccess> getSrcAccesses();

	/**
	 * Returns the value of the '<em><b>Dst Accesses</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Accesses</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency_DstAccesses()
	 * @model
	 * @generated
	 */
	EList<EAccess> getDstAccesses();

} // SubpassDependency

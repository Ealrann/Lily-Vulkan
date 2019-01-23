/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.lily.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Barrier#getSrcStage <em>Src Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Barrier#getDstStage <em>Dst Stage</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBarrier()
 * @model abstract="true"
 * @generated
 */
public interface Barrier extends EObject
{
	/**
	 * Returns the value of the '<em><b>Src Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Stage</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EPipelineStage
	 * @see #setSrcStage(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBarrier_SrcStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getSrcStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Barrier#getSrcStage <em>Src Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Stage</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EPipelineStage
	 * @see #getSrcStage()
	 * @generated
	 */
	void setSrcStage(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Dst Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Stage</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EPipelineStage
	 * @see #setDstStage(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBarrier_DstStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getDstStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Barrier#getDstStage <em>Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Stage</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EPipelineStage
	 * @see #getDstStage()
	 * @generated
	 */
	void setDstStage(EPipelineStage value);

} // Barrier

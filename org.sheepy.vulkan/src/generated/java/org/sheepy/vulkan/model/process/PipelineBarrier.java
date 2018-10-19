/**
 */
package org.sheepy.vulkan.model.process;

import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.PipelineBarrier#getSrcStage <em>Src Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.PipelineBarrier#getDstStage <em>Dst Stage</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.ProcessPackage#getPipelineBarrier()
 * @model abstract="true"
 * @generated
 */
public interface PipelineBarrier extends IProcessUnit
{
	/**
	 * Returns the value of the '<em><b>Src Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setSrcStage(EPipelineStage)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getPipelineBarrier_SrcStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getSrcStage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.PipelineBarrier#getSrcStage <em>Src Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getSrcStage()
	 * @generated
	 */
	void setSrcStage(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Dst Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setDstStage(EPipelineStage)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getPipelineBarrier_DstStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getDstStage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.PipelineBarrier#getDstStage <em>Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getDstStage()
	 * @generated
	 */
	void setDstStage(EPipelineStage value);

} // PipelineBarrier

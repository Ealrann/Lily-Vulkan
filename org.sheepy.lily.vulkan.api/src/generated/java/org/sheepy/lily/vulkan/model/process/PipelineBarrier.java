/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.root.LObject;
import org.sheepy.vulkan.model.barrier.Barrier;
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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getBarriers <em>Barriers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getSrcStage <em>Src Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getDstStage <em>Dst Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getSrcQueue <em>Src Queue</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getDstQueue <em>Dst Queue</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPipelineBarrier()
 * @model
 * @generated
 */
public interface PipelineBarrier extends LObject, IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Barriers</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.barrier.Barrier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Barriers</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPipelineBarrier_Barriers()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Barrier> getBarriers();

	/**
	 * Returns the value of the '<em><b>Src Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setSrcStage(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPipelineBarrier_SrcStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getSrcStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getSrcStage <em>Src Stage</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setDstStage(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPipelineBarrier_DstStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getDstStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getDstStage <em>Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getDstStage()
	 * @generated
	 */
	void setDstStage(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Src Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Queue</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Queue</em>' reference.
	 * @see #setSrcQueue(AbstractProcess)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPipelineBarrier_SrcQueue()
	 * @model
	 * @generated
	 */
	AbstractProcess getSrcQueue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getSrcQueue <em>Src Queue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Queue</em>' reference.
	 * @see #getSrcQueue()
	 * @generated
	 */
	void setSrcQueue(AbstractProcess value);

	/**
	 * Returns the value of the '<em><b>Dst Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Queue</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Queue</em>' reference.
	 * @see #setDstQueue(AbstractProcess)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPipelineBarrier_DstQueue()
	 * @model
	 * @generated
	 */
	AbstractProcess getDstQueue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getDstQueue <em>Dst Queue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Queue</em>' reference.
	 * @see #getDstQueue()
	 * @generated
	 */
	void setDstQueue(AbstractProcess value);

} // PipelineBarrier

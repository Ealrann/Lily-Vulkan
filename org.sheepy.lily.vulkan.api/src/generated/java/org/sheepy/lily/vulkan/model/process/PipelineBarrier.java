/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.core.model.root.LObject;
import org.sheepy.lily.vulkan.model.resource.Barrier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getBarrier <em>Barrier</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getSrcQueue <em>Src Queue</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getDstQueue <em>Dst Queue</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPipelineBarrier()
 * @model
 * @generated
 */
public interface PipelineBarrier extends LObject, IPipelineUnit
{
	/**
	 * Returns the value of the '<em><b>Barrier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Barrier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Barrier</em>' containment reference.
	 * @see #setBarrier(Barrier)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPipelineBarrier_Barrier()
	 * @model containment="true"
	 * @generated
	 */
	Barrier getBarrier();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getBarrier <em>Barrier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Barrier</em>' containment reference.
	 * @see #getBarrier()
	 * @generated
	 */
	void setBarrier(Barrier value);

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

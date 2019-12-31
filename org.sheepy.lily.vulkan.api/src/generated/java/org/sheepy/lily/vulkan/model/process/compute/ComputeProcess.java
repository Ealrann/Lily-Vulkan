/**
 */
package org.sheepy.lily.vulkan.model.process.compute;

import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputeProcess#getPipelinePkg <em>Pipeline Pkg</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeProcess()
 * @model
 * @generated
 */
public interface ComputeProcess extends AbstractProcess
{

	/**
	 * Returns the value of the '<em><b>Pipeline Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipeline Pkg</em>' containment reference.
	 * @see #setPipelinePkg(PipelinePkg)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeProcess_PipelinePkg()
	 * @model containment="true"
	 * @generated
	 */
	PipelinePkg getPipelinePkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeProcess#getPipelinePkg <em>Pipeline Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pipeline Pkg</em>' containment reference.
	 * @see #getPipelinePkg()
	 * @generated
	 */
	void setPipelinePkg(PipelinePkg value);} // ComputeProcess

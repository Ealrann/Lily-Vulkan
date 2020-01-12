/**
 */
package org.sheepy.lily.vulkan.model.process.compute;

import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.vulkan.model.process.IVkPipeline;
import org.sheepy.lily.vulkan.model.resource.Shader;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getShader <em>Shader</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputePipeline()
 * @model
 * @generated
 */
public interface ComputePipeline extends IVkPipeline, Maintainable<ComputePipeline>
{

	/**
	 * Returns the value of the '<em><b>Shader</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shader</em>' reference.
	 * @see #setShader(Shader)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputePipeline_Shader()
	 * @model
	 * @generated
	 */
	Shader getShader();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getShader <em>Shader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shader</em>' reference.
	 * @see #getShader()
	 * @generated
	 */
	void setShader(Shader value);} // ComputePipeline
